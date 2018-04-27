function addLibro() {
    var tit = document.getElementById("tit").value;
    var aut = document.getElementById("aut").value;
    //Creazione e compilazione della richiesta
    var param = "tit=" + tit + "&aut=" + aut;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function () {
        if ((request.readyState === 4) && (request.status === 200)) {
            mostraLibri();
        }
    };
    request.open("POST", "addLibro", true);
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.send(param);
}

function deleteLibro(tit) {
    var param = "tit=" + tit;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function () {
        if ((request.readyState === 4) && (request.status === 200)) {
            mostraLibri();
        }
    };
    request.open("GET", "deleteLibro?" + param, true);
    request.send();
}

function mostraLibri() {
    var request = new XMLHttpRequest();
    request.onreadystatechange = function () {
        if ((request.readyState === 4) && (request.status === 200)) {
            displayLibri(request.responseText);
        }
    }
    request.open("POST", "allLibri", true);
    request.send();
}

/**
 * Funzione che effettua l'output della risposta HTTP
 * @param {string} responseTXT: contenuto della risposta http
 */
function displayLibri(responseTXT) {
    var res = document.getElementById("ll");
    var out = "";
    var jres = JSON.parse(responseTXT);
    for (var i = 0; i < jres.length; i++) {
        out += "<tr><td>" + jres[i].titolo + "</td><td>" + jres[i].autore + "</td><td>" +
        "<input type=\"button\" value=\"Elimina\" onclick=\"deleteLibro('"+jres[i].titolo+"')\"/>"+
        "</td></tr>";
    }
    res.innerHTML = out;
}
