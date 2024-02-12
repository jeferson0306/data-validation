import React, {Component} from 'react';
import './App.css';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            cpf: '', validationMessage: '', isValid: null
        };
    }

    handleCPFChange = (event) => {
        this.setState({cpf: event.target.value, validationMessage: '', isValid: null});
    }

    handleSubmit = async (event) => {
        event.preventDefault();
        const {cpf} = this.state;
        try {
            const response = await fetch(`http://localhost:8080/v1/api/validate-cpf/${cpf}`);
            if (response.status === 200) {
                const data = await response.json();
                const isValid = data.isValid;
                this.setState({validationMessage: data.message, isValid: isValid});
            } else {
                this.setState({validationMessage: 'Invalid CPF', isValid: false});
            }
        } catch (error) {
            console.error('Error:', error);
        }
    }

    render() {
        const {validationMessage, isValid} = this.state;
        let inputClassName = 'cpf-input';

        if (isValid === true) {
            inputClassName += ' valid';
        } else if (isValid === false) {
            inputClassName += ' invalid';
        }

        return (<div className="App">
            <h1>CPF Validation</h1>
            <form onSubmit={this.handleSubmit}>
                <label htmlFor="cpf">Enter the cpf below to start validation</label>
                <input
                    type="text"
                    id="cpf"
                    name="cpf"
                    placeholder="Ex: 000.000.000-00"
                    className={inputClassName}
                    value={this.state.cpf}
                    onChange={this.handleCPFChange}
                />
                <button type="submit">Validate Cpf</button>
            </form>
            {validationMessage && <p className={isValid ? 'valid' : 'invalid'}>{validationMessage}</p>}
        </div>);
    }

}

export default App;
