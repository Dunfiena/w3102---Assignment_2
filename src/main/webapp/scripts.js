function displayLogin() {
    let modal = document.getElementById('loginModalID');
    if (modal.style.display === 'none'){
        modal.style.display = 'block'
    }else if(modal.style.display === 'block'){
        modal.style.display = 'none'
    }
}
function displayLogin2() {
    let modal = document.getElementById('regModalID');
    modal.style.display = 'none'
    let modal2 = document.getElementById('loginModalID')
    modal2.style.display = 'block'
}

function displayReg() {
    let modal = document.getElementById('loginModalID');
    modal.style.display = 'none'
    let modal2 = document.getElementById('regModalID')
    modal2.style.display = 'block'
}
function displayregOff(){
    let modal2 = document.getElementById('regModalID')
    modal2.style.display = 'none'
}

function itemModel(id) {
    let modal = document.getElementById(id);
    if (modal.style.display === 'none'){
        modal.style.display = 'block'
    }else if(modal.style.display === 'block'){
        modal.style.display = 'none'
    }
}