
window.color = {
	red: 'rgb(255, 99, 132)',
	orange: 'rgb(255, 159, 64)',
	yellow: 'rgb(255, 205, 86)',
	green: 'rgb(75, 192, 192)',
	blue: 'rgb(54, 162, 235)',
	purple: 'rgb(153, 102, 255)',
	grey: 'rgb(201, 203, 207)'
};

function graficoRadares(radares) {
    var ctx = document.getElementById('chartRadares').getContext('2d');

    data = {
        datasets: [{
            label: 'Radares',
            backgroundColor: [
                        window.color.green,
                        window.color.yellow,
                        window.color.orange,
                        window.color.red,
                        window.color.blue,
					],
            data: [radares[0], radares[1], radares[2], radares[3], radares[4]]
        }],
    
        labels: [
            '30 km/h',
            '40 km/h',
            '60 km/h',
            '80 km/h',
            '40 km/h dia, 60 km/h noite e feriados'
        ]
    }; 
    
    var myDoughnutChart = new Chart(ctx, {
        type: 'doughnut',
        data: data,
        options: {
            responsive: true,
            legend: {
                position: 'top',
            },
            title: {
                display: true,
                text: 'Limite de velocidade dos Radares'
            },
            rotation: Math.PI,
            circumference: Math.PI,
            animation: {
                animateScale: true,
                animateRotate: true
            }
        }
    });
}