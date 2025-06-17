document.getElementById('feedbackForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const name = document.getElementById('name').value;
    const message = document.getElementById('message').value;
    const responseMessage = document.getElementById('responseMessage');

    fetch('http://localhost:8080/submit', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, message }),
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.text();
    })
    .then(data => {
        responseMessage.textContent = data;
        responseMessage.style.color = '#00FF00';
    })
    .catch(error => {
        console.error('Ошибка:', error);
        responseMessage.textContent = 'Ошибка: бэкенд недоступен. Проверьте соединение.';
        responseMessage.style.color = '#FF4500';
    });
});