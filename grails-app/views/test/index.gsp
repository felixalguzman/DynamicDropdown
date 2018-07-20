<%@ page import="dropdown.City" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Chained Select Test</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>

        function categoryChanged(categoryId) {
            console.log("Entro");
            $.ajax({
                type: 'POST',
                data: 'categoryId=' + categoryId,
                url: "${g.createLink(controller:'test',action:'categoryChanged')}",
                success: function (data, textStatus) {
                    $('#subContainer').html(data);
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                }
            });
        }

    </script>
</head>

<body>

<div class="content scaffold" role="main">
    <h1>Ciudades y Equipos</h1>
    <div class="form-group">
        <ol class="property-list">
            <li class="fieldcontain">
                <span id="name-label" class="property-label">Ciudades</span>
                <g:select id="category" name="category.id" from="${City.listOrderByName()}" optionKey="id"
                          noSelection="[null: ' ']"
                          onchange="categoryChanged(this.value);"/>
            </li>
        </ol>


    </div>

    <div class="form-group">

        <ol class="property-list">
            <li class="fieldcontain">
                <span  class="property-label">Equipos</span>
                <span id="subContainer"></span>
            </li>
        </ol>
    </div>
</div>
</body>
</html>