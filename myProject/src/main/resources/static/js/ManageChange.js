var click = document.getElementById('changeManage');
click.onclick = function () {
    document.querySelector('.manageChild').style.display = 'block';
    document.querySelector('.serviceChild').style.display = 'none';
    document.querySelector('#FlightChild').style.display = 'none';
    document.querySelector('.ExperiencesChild').style.display = 'none';
}