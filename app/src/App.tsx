import './App.css';
import { useState } from 'react';
import { useFetch } from './services/api';

type listaTipoDados = {
  tipo: string
}

function App() {
  const {data: tipoDados} = useFetch<listaTipoDados[]>('http://localhost:8080/api/tipo-banco-de-dados')

  

  return (
    <div>
      
      <main>
        <form action="/form" method="post">
          <div>
            <label>Servidor :</label>
            <input type="text" id="servidor" name="servidor" />
          </div>
          <div>
            <label>Tipo :</label>
            
            <select className="tipo" id="tipo">
            {tipoDados?.map( tipo => {
              return(
              <option value="teste">{tipo.tipo}</option>
              )
              })}
            </select>
              
          </div>
          <div>
            <label>Login:</label>
            <input type="text" id="login" name="login" />
          </div>
          <div>
            <label>Senha:</label>
            <input type="text" id="senha" name="senha" />
          </div>

          <div className="botoes">
            <button type="submit">Cadastrar</button>
            <button type="submit">Consultar</button>
            <button type="submit">Alterar</button>
            <button type="submit">Deletar</button>
          </div>
        </form>
      </main>
    </div>
         
  );
}

export default App
