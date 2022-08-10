import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import {Container, Paper} from "@mui/material";
import {useState} from "react";
import Button from "@mui/material/Button";

export default function Notes() {
    const paperStyle = {padding:'50px 20px', width: 600, margin:"20px auto"}
    const[name,setName] = useState('')
    let result = ''
    const [mess, setMess] = React.useState('');
    const[description,setDescription] = useState('')
    const handleClick =(e)=> {
        e.preventDefault()
        const notes = {name,description}
        fetch("http://localhost:8080/notes", {
            method:"POST",
            headers: {"Content-Type":"application/json"},
            body:JSON.stringify(notes)
        }).then((response)=>{
            setMess(response)
        })
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
            <h1 style={{color:"blue"}}><u>Add a note</u></h1>
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
            <Button variant="contained" color="secondary" onClick={handleClick}>
                Submit
            </Button>

        </Box>
            <h1></h1>
            {result}
        </Paper>
        </Container>
    );
}
