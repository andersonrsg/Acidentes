
var dognutChartAccidentType;

window.color = {
	red: 'rgb(255, 99, 132)',
	orange: 'rgb(255, 159, 64)',
	yellow: 'rgb(255, 205, 86)',
	green: 'rgb(75, 192, 192)',
	blue: 'rgb(54, 162, 235)',
	purple: 'rgb(153, 102, 255)',
	grey: 'rgb(201, 203, 207)'
};

function accidentType(ages) {

    var ctx = document.getElementById('doughnut-type-chart').getContext('2d');

    var datas = [];
    var labels = [];
    var backgroundColor = [];

    datas.push(ages.atropelamento);    
    labels.push("Atropleamento");
    backgroundColor.push('#004D40');

    datas.push(ages.tombamento);    
    labels.push("Tombamento");
    backgroundColor.push('#AD0E26');

    datas.push(ages.queda);    
    labels.push("Queda");
    backgroundColor.push('#FFC107');

    datas.push(ages.abalroamento);    
    labels.push("Abalroamento");
    backgroundColor.push('#D81B60');
    
    datas.push(ages.colisao);    
    labels.push("Colisão");
    backgroundColor.push('#8D7DB0');

    datas.push(ages.eventual);    
    labels.push("Eventual");
    backgroundColor.push('#56E915');

    datas.push(ages.choque);    
    labels.push("Choque");
    backgroundColor.push('#5702FC');

    datas.push(ages.capotagem);    
    labels.push("Capotagem");
    backgroundColor.push('#B5DB2D');

    datas.push(ages.outros);    
    labels.push("Outros");
    backgroundColor.push('#7BE877');

    data = {
        datasets: [{
            label: 'Radares',
            backgroundColor: backgroundColor,
            data: datas
        }],
    
        labels: labels
    }; 
    
    dognutChartAccidentType = new Chart(ctx, {
        type: 'pie',
        data: data,
        options: {
            responsive: true,
            legend: {
                position: 'top',
            },
            title: {
                display: true,
                text: 'Tipos de acidente no período selecionado'
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