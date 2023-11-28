//Armazenar e Exibir o nome da empresa
const nomeDaEmpresa = " "
console.log(nomeDaEmpresa)


const form = document.querySelector('.form');
form.addEventListener('submit', cadastrarReceita);


//Array para lista de receitas e objeto

const receitas = [];

function cadastrarReceita(event) {
  event.preventDefault(); // Previne o comportamento padrão de envio do formulário

  // Obtém os valores dos campos do formulário
  const id = document.querySelector('#id').value;
  const titulo = document.querySelector('#titulo').value;
  const dificuldade = document.querySelector('#dificuldade').value;
  const ingredientes = document.querySelector('#ingredientes').value;
  const modoDePreparo = document.querySelector('#instrucoesDePreparo').value;
  const vegana = document.querySelector('#vegana').checked;

  // Valida se todos os campos foram preenchidos corretamente
  if (id && titulo && dificuldade && ingredientes && modoDePreparo) {
    // Cria um objeto com as informações da nova receita
    const novaReceita = {
      id: id,
      titulo: titulo,
      dificuldade: dificuldade,
      ingredientes: ingredientes,
      modoDePreparo: modoDePreparo,
      vegana: vegana
    };

    // Adiciona a nova receita ao array de receitas
    receitas.push(novaReceita);

    // Limpa os campos do formulário
    document.querySelector('#id').value = '';
    document.querySelector('#titulo').value = '';
    document.querySelector('#dificuldade').value = 'fácil';
    document.querySelector('#ingredientes').value = '';
    document.querySelector('#instrucoesDePreparo').value = '';
    document.querySelector('#vegana').checked = false;

    // Exibe uma mensagem de sucesso
    const mensagem = document.querySelector('#mensagem');
    mensagem.textContent = 'Receita cadastrada com sucesso!';

    // Atualiza a lista de receitas na página
    atualizarListaDeReceitas();
  } else {
    // Exibe uma mensagem de erro se algum campo estiver vazio
    const mensagem = document.querySelector('#mensagem');
    mensagem.textContent = 'Por favor, preencha todos os campos.';
  }
}



//Atualizando as Receitas, criando e adicionando os novos campos dento do array receitas
function atualizarListaDeReceitas() {
    const container = document.querySelector('#button-exibir');
    container.innerHTML = ''; // Limpa o conteúdo anterior do container
  
    for (let i = 0; i < receitas.length; i++) {
      const receita = receitas[i];
  
      const novaReceita = document.createElement('div');
      novaReceita.classList.add('receita');
  
      const titulo = document.createElement('h3');
      titulo.textContent = receita.titulo;
  
      const dificuldade = document.createElement('p');
      dificuldade.textContent = `Dificuldade: ${receita.dificuldade}`;
  
      const ingredientes = document.createElement('p');
      ingredientes.textContent = `Ingredientes: ${receita.ingredientes}`;
  
      const modoDePreparo = document.createElement('p');
      modoDePreparo.textContent = `Modo de Preparo: ${receita.modoDePreparo}`;
  
      const vegana = document.createElement('p');
      vegana.textContent = `Vegana: ${receita.vegana ? 'Sim' : 'Não'}`;
  
      novaReceita.appendChild(titulo);
      novaReceita.appendChild(dificuldade);
      novaReceita.appendChild(ingredientes);
      novaReceita.appendChild(modoDePreparo);
      novaReceita.appendChild(vegana);
  
      container.appendChild(novaReceita);
    }
  }
  

//Exbindo as receitas no Container especificado, logo após o click no botão cadastrar receitas
  function exibirReceitas() {
    let html = '';
  
    for (let i = 0; i < receitas.length; i++) {
      const receita = receitas[i];
      html += `<div class="receita">
                <h2>${receita.titulo}</h2>
                <p>ID: ${receita.id}</p>
                <p class="dif">Dificuldade: ${receita.dificuldade}</p>
                <p>Ingredientes: ${receita.ingredientes}</p>
                <p>Modo de preparo: ${receita.modoDePreparo}</p>
                <p>Vegana: ${receita.vegana ? 'Sim' : 'Não'}</p>
              </div>`;
    }

    const container = document.querySelector('#container');
    container.innerHTML = html;
}
const inputFile = document.querySelector("#picture__input");
const pictureImage = document.querySelector(".picture__image");
const pictureImageTxt = "Upload da Imagem";
pictureImage.innerHTML = pictureImageTxt;

inputFile.addEventListener("change", function (e) {
  const inputTarget = e.target;
  const file = inputTarget.files[0];

  if (file) {
    const reader = new FileReader();

    reader.addEventListener("load", function (e) {
      const readerTarget = e.target;

      const img = document.createElement("img");
      img.src = readerTarget.result;
      img.classList.add("picture__img");

      pictureImage.innerHTML = "";
      pictureImage.appendChild(img);
    });

    reader.readAsDataURL(file);
  } else {
    pictureImage.innerHTML = pictureImageTxt;
  }
});

  

