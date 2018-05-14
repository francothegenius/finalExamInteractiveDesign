import React, { Component } from 'react';
import './NoteInput.css';

class NoteInput extends Component{
    constructor(props){
        super(props);
        this.state = {
            newNoteContent: '',
        };

        this.handleUserInput = this.handleUserInput.bind(this);
        this.writeNote = this.writeNote.bind(this);
    }

    // cambia input, nueva nota
    handleUserInput(e){
        this.setState({
            newNoteContent: e.target.value, // the value of the text input
        })
    }

    writeNote(){
        // metodo establece nota
        this.props.addNote(this.state.newNoteContent, this.state.newimage);


        // nota vacia
        this.setState({
            newNoteContent: '',
            newimage: '',
        })
    }
    render(){
        return(
            <div className="inputBackground">
                <input className="noteInput"
                placeholder="Escribe una tarea..."
                value={this.state.newNoteContent} 
                onChange={this.handleUserInput} />
                <button className="noteButton"
                onClick={this.writeNote}>Añadir nota</button>
            </div>
        )
    }
}



export default NoteInput;