
var dognutChartAge;

window.color = {
	red: 'rgb(255, 99, 132)',
	orange: 'rgb(255, 159, 64)',
	yellow: 'rgb(255, 205, 86)',
	green: 'rgb(75, 192, 192)',
	blue: 'rgb(54, 162, 235)',
	purple: 'rgb(153, 102, 255)',
	grey: 'rgb(201, 203, 207)'
};

function graficoIdade(ages) {

    var ctx = document.getElementById('doughnut-age-chart').getContext('2d');

    var datas = [];
    var labels = [];
    var backgroundColor = [];

    datas.push(ages.ageMenor18);    
    labels.push("Menor de idade");
    backgroundColor.push('#004D40');

    datas.push(ages.age18_24);    
    labels.push("18 - 24");
    backgroundColor.push('#AD0E26');

    datas.push(ages.age25_34);    
    labels.push("25 - 34");
    backgroundColor.push('#FFC107');

    datas.push(ages.age35_44);    
    labels.push("35 - 44");
    backgroundColor.push('#D81B60');
    
    datas.push(ages.age45_54);    
    labels.push("45 - 54");
    backgroundColor.push('#8D7DB0');

    datas.push(ages.age55_64);    
    labels.push("55 - 64");
    backgroundColor.push('#56E915');

    datas.push(ages.ageTerceira);    
    labels.push("Terceira Idade");
    backgroundColor.push('#5702FC');

    data = {
        datasets: [{
            label: 'Radares',
            backgroundColor: backgroundColor,
            data: datas
        }],
    
        labels: labels
    }; 
    
    dognutChartAge = new Chart(ctx, {
        type: 'pie',
        data: data,
        options: {
            responsive: true,
            legend: {
                position: 'top',
            },
            title: {
                display: true,
                text: 'Envolvimento em acidentes fatais - Gráfico de idade'
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