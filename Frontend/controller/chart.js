
function graficoRadares(radares) {
    var ctx = document.getElementById('chartRadares').getContext('2d');

    data = {
        datasets: [{
            data: [radares[0], radares[1], radares[2], radares[3], radares[4]]
        }],
    
        labels: [
            '30 km/h',
            '40 km/h',
            '60 km/h',
            '80 km/h',
            '40/60 km/h'
        ]
    }; 
    
    var myDoughnutChart = new Chart(ctx, {
        type: 'doughnut',
        data: data,
        options: {}
    });
}