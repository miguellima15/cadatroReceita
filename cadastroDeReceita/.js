const form = document.querySelector('.form');
form.addEventListener('submit', cadastrarReceita);
let receitas = [];
atualizarListaDeReceitas();
function cadastrarReceita(event) {
  event.preventDefault();

  const id = document.querySelector('#id').value;
  const titulo = document.querySelector('#titulo').value;
  const dificuldade = document.querySelector('#dificuldade').value;
  const ingredientes = document.querySelector('#ingredientes').value;
  const modoDePreparo = document.querySelector('#instrucoesDePreparo').value;
  const vegana = document.querySelector('#vegana').checked;

  if (id && titulo && dificuldade && ingredientes && modoDePreparo && vegana) {
    const novaReceita = {
      id: id,
      tidareceita: titulo,
      modepreparo: modoDePreparo,
      ingredientes: ingredientes,
      vegana: vegana,
      dificuldade: dificuldade
    };
    fetch('http://localhost:8080/api/receita', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(novaReceita),
    })
      .then(response => {
        if (!response.ok) {
          throw new Error(`Erro na solicitação: ${response.status} ${response.statusText}`);
        }
        return response.json();
      })
      .then(data => {
        console.log('Receita cadastrada com sucesso:', data);
        atualizarListaDeReceitas();
      })
      .catch(error => {
        console.error('Erro ao cadastrar receita:', error);
      });
  } else {
    const mensagem = document.querySelector('#mensagem');
    mensagem.textContent = 'Por favor, preencha todos os campos.';
  }
}

function atualizarListaDeReceitas() {
  fetch('http://localhost:8080/api/receita')
      .then(response => response.json())
      .then(data => {
          receitas = data;
          const listaReceitas = document.querySelector('#lista-receitas');
          listaReceitas.innerHTML = ''; // Limpa o conteúdo anterior da lista

          for (let i = 0; i < receitas.length; i++) {
              const receita = receitas[i];

              const novaReceita = document.createElement('div');
              novaReceita.classList.add('receita');

              const titulo = document.createElement('h3');
              titulo.textContent = receita.tidareceita;

              const dificuldade = document.createElement('p');
              dificuldade.textContent = `Dificuldade: ${receita.dificuldade}`;

              const ingredientes = document.createElement('p');
              ingredientes.textContent = `Ingredientes: ${receita.ingredientes}`;

              const modoDePreparo = document.createElement('p');
              modoDePreparo.textContent = `Modo de Preparo: ${receita.modepreparo}`;

              const vegana = document.createElement('p');
              vegana.textContent = `Vegana: ${receita.vegana ? 'Sim' : 'Não'}`;

              novaReceita.appendChild(titulo);
              novaReceita.appendChild(dificuldade);
              novaReceita.appendChild(ingredientes);
              novaReceita.appendChild(modoDePreparo);
              novaReceita.appendChild(vegana);

              listaReceitas.appendChild(novaReceita);
          }
      })
      .catch(error => {
          console.error('Erro ao obter receitas:', error);
      });
}

