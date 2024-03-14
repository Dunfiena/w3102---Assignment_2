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

function checklogin1(login, available, id) {
    var quan = document.getElementById(id).value
    if (login === false) {
        alert("Please log in before leaving a review")
        displayLogin()
        return false
    } else {
        return true
    }
}

function checklogin2(login, available, id){
    var quan = document.getElementById(id)
    if (login === false){
        alert("Please log in before adding items to the cart")
        displayLogin()
        return false
    }else{
        if(checkQuantity(available, quan.value) === true){
            return true
        }else{
            alert("Sorry, there are not enough available items.  Please try again on another day or contact admin")
            return false
        }
    }

    function checkQuantity(available, quantity){
        if (parseInt(quantity, 10) <= parseInt(available, 10)){
            return true;
        }
    }
}