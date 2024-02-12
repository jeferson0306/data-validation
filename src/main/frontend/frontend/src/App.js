import React, {Component} from 'react';
import './App.css'; // Importando o arquivo de estilos CSS

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            cpf: '', validationMessage: ''
        };
    }

    handleCPFChange = (event) => {
        this.setState({cpf: event.target.value});
    }

    handleSubmit = async (event) => {
        event.preventDefault();
        const {cpf} = this.state;
        try {
            const response = await fetch(`/v1/api/validate-cpf/${cpf}`);
            const data = await response.json();
            this.setState({validationMessage: data.message});
        } catch (error) {
            console.error('Error:', error);
        }
    }

    render() {
        const {validationMessage} = this.state;
        return (<div className="App">
                <h1>Validação de CPF</h1>
                <form onSubmit={this.handleSubmit}>
                    <label htmlFor="cpf">CPF</label>
                    <input
                        type="text"
                        id="cpf"
                        name="cpf"
                        placeholder="Ex: 000.000.000-00"
                        className="cpf-input"
                        value={this.state.cpf}
                        onChange={this.handleCPFChange}
                    />
                    <button type="submit">Validate Cpf</button>
                </form>
                {validationMessage && <p>{validationMessage}</p>}
            </div>);
    }
}

export default App;
