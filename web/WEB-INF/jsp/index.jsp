<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <script src="./resources/manageLibri.js"   type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Disable caching -->
        <meta http-equiv="cache-control" content="max-age=0" />
        <meta http-equiv="cache-control" content="no-cache" />
        <title>Libri</title>
    </head> 
    <body>
        <h1>Libri</h1>
        <div>
            <table>
                <thead>
                <th>Titolo</th>
                <th>Autore</th>
                </thead>
            </table>
            <table id="ll">
            </table>
        </div>
        <h1>Inserisci un nuovo libro</h1>
        <form>
            <p>
                <label>Titolo</label>
                <input type="tit" id="tit" />
            </p>
            <p>
                <label>Autore</label>
                <input type="aut" id="aut" />
            </p>
            <input type="button" value="Aggiungi" onClick="javascript:addLibro()"/>


        </form>
    </body>
    <script>mostraLibri()</script>
</html>