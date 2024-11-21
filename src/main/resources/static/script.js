document.getElementById('filterButton').addEventListener('click', () => {
    const region = document.getElementById('regionFilter').value;
    const year = document.getElementById('yearFilter').value;
    fetchPopulationData(region, year);
});

function fetchPopulationData(region = '', year = '') {
    let url = '/api/population';
    if (region || year) {
        url += `?region=${region}&year=${year}`;
    }

    fetch(url)
        .then(response => response.json())
        .then(data => {
            const ageGroups = data.map(item => item.ageGroup);
            const males = data.map(item => item.males);
            const females = data.map(item => item.females);

            const ctx = document.getElementById('population-pyramid').getContext('2d');

            new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: ageGroups,
                    datasets: [
                        {
                            label: 'Males',
                            data: males,
                            backgroundColor: 'rgba(54, 162, 235, 0.6)', // Blue for Males
                            borderColor: 'rgba(54, 162, 235, 1)',
                            borderWidth: 1
                        },
                        {
                            label: 'Females',
                            data: females,
                            backgroundColor: 'rgba(255, 99, 132, 0.6)', // Red for Females
                            borderColor: 'rgba(255, 99, 132, 1)',
                            borderWidth: 1
                        }
                    ]
                },
                options: {
                    indexAxis: 'y',
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
}

// Initial load without filters
fetchPopulationData();
