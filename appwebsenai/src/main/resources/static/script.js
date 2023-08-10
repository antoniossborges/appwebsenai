const form = document.getElementById('cadastroForm');
const tabelaPessoas = document.getElementById("tabelaPessoas").getElementsByTagName('tbody')[0];
const btnListarPessoas = document.getElementById("btnListarPessoas");


form.addEventListener("submit", function(event) {
    event.preventDefault(); // Impede o envio do formulário tradicional

    let formData = new FormData(form);

    let params = new URLSearchParams(formData); // Cria uma URLSearchParams com os dados do FormData

    let url = "/person?" + params.toString();

    fetch(url, {
        method: "POST"
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById('name').value = data.name;
            document.getElementById('id').value = data.id;
            document.getElementById('sexo').value = data.sexo;
        })
        .catch(error => {
            console.error("Erro ao enviar dados:", error);
        });
});

btnListarPessoas.addEventListener("click", function() {
    // Fazer uma solicitação GET para obter a lista de pessoas
    fetch("/all")  // Substitua pelo endpoint correto do seu backend
        .then(response => response.json())
        .then(data => {
            // Limpar a tabela antes de preencher novamente
            tabelaPessoas.innerHTML = "";

            // Preencher a tabela com os dados das pessoas
            data.forEach(function(pessoa) {
                let row = tabelaPessoas.insertRow();

                let cellId = row.insertCell(0);
                let cellNome = row.insertCell(1);
                let cellSexo = row.insertCell(2);

                cellId.textContent  = pessoa.id;
                cellNome.textContent  = pessoa.name;
                cellSexo.textContent  = pessoa.sexo;
            });
        })
        .catch(error => {
            console.error("Erro ao obter lista de pessoas:", error);
        });
});



/*form.addEventListener('submit', function(event) {
    event.preventDefault();

    const formData = new FormData(form);
    const data = {};

    formData.forEach((value, key) => {
        data[key] = value;
    });

    const apiUrl = 'http://localhost:8080/person';
    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    };

    fetch(apiUrl, requestOptions)
        .then(response => response.json())
        .then(result => {
            document.getElementById('id').textContent = data.id;
            console.log('Dados enviados com sucesso:', result);
        })
        .catch(error => {
            console.error('Erro ao enviar dados:', error);
        });
});*/



