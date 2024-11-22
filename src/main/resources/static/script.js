let populationChart;
document.getElementById('filterButton').addEventListener('click', () => {
    const region = document.getElementById('regionFilter').value;
    const year = document.getElementById('yearFilter').value;
    fetchPopulationData(country, year);
});

function fetchPopulationData(region = '', year = '') {
    let url = '/api/population';
    if (region || year) {
        url += `?country=${country}&year=${year}`;
    }

    fetch(url)
        .then(response => response.json())
        .then(data => {
            const ageGroups = data.map(item => item.ageGroup);
            const males = data.map(item => item.males);
            const females = data.map(item => item.females);

            if (populationChart) {
                populationChart.destroy();
            }
            const ctx = document.getElementById('population-pyramid').getContext('2d');

            populationChart = new Chart(ctx, {
                type: 'bar',
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
                    indexAxis: 'y',
                    responsive: true,
                    interaction: {
                        mode: 'nearest',
                        intersect: true,
                    },
                    plugins: {
                        tooltip: {
                            callbacks: {
                                label: function(context) {
                                    let label = context.dataset.label || '';
                                    if (label) {
                                        label += ': ';
                                    }
                                    label += context.raw.toLocaleString(); // Ensuring proper format for population count
                                    return label;
                                }
                            }
                        },
                        legend: {
                            display: true,
                            position: 'top',
                        },
                        title: {
                            display: true,
                            text: 'Population Pyramid by Age Group'
                        }
                    },
                    scales: {
                        x: {
                            beginAtZero: true,
                            title: {
                                display: true,
                                text: 'Population Count'
                            }
                        },
                        y: {
                            title: {
                                display: true,
                                text: 'Age Groups'
                            }
                        }
                    },
                    animation: {
                        duration: 1000,
                        easing: 'easeInOutQuad'
                    }

                }
            });
        })
        .catch(error => console.error('Error fetching population data:', error));
}

fetchPopulationData();
