// app.js
window.onload = function() {
    fetch('/api/population')
        .then(response => response.json())
        .then(data => {
            const ageGroups = data.map(item => item.ageGroup);
            const males = data.map(item => item.males);
            const females = data.map(item => item.females);

            const ctx = document.getElementById('population-pyramid').getContext('2d');

            new Chart(ctx, {
                type: 'horizontalBar',
                data: {
                    labels: ageGroups,
                    datasets: [
                        {
                            label: 'Males',
                            data: males,
                            backgroundColor: 'rgba(54, 162, 235, 0.6)',
                            borderColor: 'rgba(54, 162, 235, 1)',
                            borderWidth: 1
                        },
                        {
                            label: 'Females',
                            data: females,
                            backgroundColor: 'rgba(255, 99, 132, 0.6)',
                            borderColor: 'rgba(255, 99, 132, 1)',
                            borderWidth: 1
                        }
                    ]
                },
                options: {
                    responsive: true,
                    scales: {
                        x: {
                            beginAtZero: true
                        }
                    }
                }
            });
        })
        .catch(error => console.error('Error fetching population data:', error));
};
