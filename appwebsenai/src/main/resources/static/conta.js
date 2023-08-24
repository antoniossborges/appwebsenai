document.addEventListener("DOMContentLoaded", function() {
    var selectPessoa = document.getElementById("selectPessoa");
    
    // Função para preencher a combobox com as informações das pessoas
    function preencherComboBoxPessoas() {
        fetch("/all")  // Substitua pela URL correta do seu backend
        .then(response => response.json())
        .then(data => {
            var option = document.createElement("option");
            option.value = null;
            option.textContent = "";
            selectPessoa.appendChild(option);
            // Preencher a combobox com as opções de pessoas
            data.forEach(function(pessoa) {
                var option = document.createElement("option");
                option.value = pessoa.id;
                option.textContent = pessoa.name;
                selectPessoa.appendChild(option);
            });
        })
        .catch(error => {
            console.error("Erro ao obter lista de pessoas:", error);
        });
    }

    // Chamar a função para preencher a combobox de pessoas
    preencherComboBoxPessoas();

    // Manipular a seleção da pessoa na combobox
    selectPessoa.addEventListener("change", function() {
        var pessoaSelecionadaId = selectPessoa.value;

        // Função para obter os detalhes da pessoa selecionada
        function obterDetalhesPessoa(id) {
            fetch(`/pessoas/${id}`)  // Substitua pela URL correta do seu backend
            .then(response => response.json())
            .then(pessoa => {
                // Preencher os campos com os detalhes da pessoa selecionada
                document.getElementById("nomePessoa").value = pessoa.nome;
            })
            .catch(error => {
                console.error("Erro ao obter detalhes da pessoa:", error);
            });
        }

        // Chamar a função para obter os detalhes da pessoa selecionada
        obterDetalhesPessoa(pessoaSelecionadaId);
    });

    // Restante do seu código...
});
