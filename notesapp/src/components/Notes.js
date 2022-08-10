import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import {Container, Paper} from "@mui/material";
import {useEffect, useState} from "react";
import Button from "@mui/material/Button";
import DialogTitle from "@mui/material/DialogTitle";
import DialogContent from "@mui/material/DialogContent";
import DialogContentText from "@mui/material/DialogContentText";
import DialogActions from "@mui/material/DialogActions";
import Dialog from "@mui/material/Dialog";


export default function Notes() {
    const[id,setId]=useState('')
    const [open, setOpen] = React.useState(false);

    const handleClickOpen = (id) => {
        setOpen(true)
        setId(id)
    };

    const handleClose = () => {
        setOpen(false);
    };

    const paperStyle = {padding:'20px 20px', width: 600, margin:"20px auto"}
    const[name,setName] = useState('')

    const[newName,setNewName]=useState('')
    const[newDescription,setNewDescription]=useState('')
    let result = ''
    const [mess, setMess] = React.useState('');
    const[description,setDescription] = useState('')
    const[allnotes,setAllnotes]= useState( [])

    const handleNewNameChange = (event) => {
        setNewName(event.target.value);
    };

    const handleNewDescriptionChange = (event) => {
        setNewDescription(event.target.value);
    };

    useEffect(()=>{
        fetch("http://localhost:8080/notes")
            .then(res=>res.json())
            .then((result)=>{
                setAllnotes(result);
                }
            )
    },[allnotes])

    const deleteNote =(id)=> {
        fetch("http://localhost:8080/notes", {
            method:"DELETE",
            headers: {"Content-Type":"application/json"},
            body:JSON.stringify(id)
        }).then((response)=>{
        })
    }

    const createNote =(e)=> {
        e.preventDefault()
        const notes = {name,description}
        fetch("http://localhost:8080/notes", {
            method:"POST",
            headers: {"Content-Type":"application/json"},
            body:JSON.stringify(notes)
        }).then((response)=>{
            setMess(response)

        })
        if(allnotes.length===0) {
            window.location.reload();
        }
    }

    const editNote =()=> {
        const newNote = {id,newName,newDescription}
        fetch("http://localhost:8080/notes", {
            method:"PATCH",
            headers: {"Content-Type":"application/json"},
            body:JSON.stringify(newNote)
        }).then((response)=>{
        })
        console.log(id)
        console.log(newName)
        console.log(newDescription)
    }


    if(mess.status >= 400) {
        result = "Error: You can't create a note with no name!"
    }
    if(mess.status>=200 && mess.status<300 ) {
        result = "Note successfully created."
    }
    return (
        <Container>
        <Paper elevation={3} style ={paperStyle}>
            <h1> Add a note </h1>
        <Box
            component="form"
            sx={{
                '& > :not(style)': { m: 1 },
            }}
            noValidate
            autoComplete="off"
        >
            <TextField id="outlined-basic" label="Name" variant="outlined" fullWidth value = {name} onChange={(e)=>setName(e.target.value)}/>

            <TextField id="outlined-basic" label="Description" variant="outlined" fullWidth value = {description} onChange={(e)=>setDescription(e.target.value)} />
            <Button variant="contained" color="secondary" onClick={createNote}>
                Submit
            </Button>
            <h1></h1>
            {result}
        </Box>

        </Paper>

            <h1> Notes </h1>
            <Paper elevation={3} style={paperStyle}>
                {
                    allnotes.map(singleNote=>(
                        <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} key={singleNote.id}>
                            Date: {singleNote.creationDate}<br/>
                            Name:{singleNote.name}<br/>
                            Address:{singleNote.description}
                            <h2> </h2>
                            <Container>
                            <Button variant="contained" color="secondary" onClick={()=>deleteNote(singleNote.id)}>
                                Delete
                            </Button >
                                <Button variant="contained" color="secondary" onClick={()=>handleClickOpen(singleNote.id)}>
                                    Edit
                                </Button >
                                <Dialog open={open} onClose={handleClose}>
                                    <DialogTitle>Edit Note</DialogTitle>
                                    <DialogContent>
                                        <TextField
                                            autoFocus
                                            margin="dense"
                                            id="name"
                                            label="Name"
                                            type="email"
                                            fullWidth
                                            variant="standard"
                                            onChange={handleNewNameChange}
                                        />
                                        <TextField
                                            autoFocus
                                            margin="dense"
                                            id="name"
                                            label="Description"
                                            type="email"
                                            fullWidth
                                            variant="standard"
                                            onChange={handleNewDescriptionChange}
                                        />
                                    </DialogContent>
                                    <DialogActions>
                                        <Button onClick={handleClose}>Cancel</Button>
                                        <Button onClick={()=>editNote(id)}>Submit</Button>
                                    </DialogActions>
                                </Dialog>
                                </Container>
                        </Paper>
                    ))
                }
            </Paper>
        </Container>
    );
}
