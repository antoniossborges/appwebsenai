const form = document.getElementById('cadastroForm');

form.addEventListener('submit', function(event) {
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
});
