<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: devnull
  Date: 29.11.16
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css"
          href="https://cdn.datatables.net/v/dt/jq-2.2.3/dt-1.10.12/datatables.min.css"/>
    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/jq-2.2.3/dt-1.10.12/datatables.min.js"></script>
    <title>Firms</title>
    <script src="/js/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" type="text/css"
          href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8"
            src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" charset="utf8"
            src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.js"></script>
</head>
<style>
    .btn {
        display: inline-block;
        padding: 6px 12px;
        margin-bottom: 0;
        font-size: 14px;
        font-weight: normal;
        line-height: 1.42857143;
        text-align: center;
        white-space: nowrap;
        vertical-align: middle;
        -ms-touch-action: manipulation;
        touch-action: manipulation;
        cursor: pointer;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
        background-image: none;
        border: 1px solid transparent;
        border-radius: 4px;
    }
    th {
        align-content: center;
    }
    table {
        width: 100%;
        cellspacing: 0;
    }
</style>
<body>
<a href="kriterium/${1}" class="btn btn-default" style="width: 50px">*</a>
<a href="kriterium/${2}" class="btn btn-default" style="width: 50px">**</a>
<a href="kriterium/${3}" class="btn btn-default" style="width: 50px">***</a>
<a href="kriterium/${4}" class="btn btn-default" style="width: 50px">****</a>
<a href="kriterium/${5}" class="btn btn-default" style="width: 50px">*****</a>
<a href="kriterium/${0}" class="btn btn-default" style="width: 50px">All</a>
<label>
    <input id="pennystock" type="checkbox"> No Pennystock
</label>
<table id="table" class="dataTable">
    <thead>
    <tr>
        <th>Symbol</th>
        <th>Spalte1</th>
        <th>Spalte2</th>
        <th>Spalte3</th>
        <th>Spalte4</th>
        <th>Spalte5</th>
        <th>Spalte6</th>
        <th>Spalte7</th>
        <th>Spalte8</th>
        <th>Spalte9</th>
        <th>Spalte10</th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <th>Symbol</th>
        <th>Spalte1</th>
        <th>Spalte2</th>
        <th>Spalte3</th>
        <th>Spalte4</th>
        <th>Spalte5</th>
        <th>Spalte6</th>
        <th>Spalte7</th>
        <th>Spalte8</th>
        <th>Spalte9</th>
        <th>Spalte10</th>
    </tr>
    </tfoot>
</table>

<form action="firm" method="get"><button>Neue Aktiengesellschaft</button></form>
<form method="post" action="update">
    <button align="left">Update</button>
</form>
<script>
    $(document).ready(function () {
        alert('${kriterium}')
        if('${kriterium}' == 5){
            alert("in 5")
            $.ajax({
                url: "getKriterium5",
                dataType: "json",
                type: "POST",
                success: function (json) {
                    $('#table').DataTable({
                        data: json,
                        columns: [
                            {data: "symbol"},
                            {data: "name_s1"},
                            {data: "konzurn_s2"},
                            {data: "price_s3"},
                            {data: "tiefstand_s4"},
                            {data: "kriterium3_s5"},
                            {data: "hochstand_s6"},
                            {data: "million_s7"},
                            {data: "durchschnittsdivende_s8"},
                            {data: "dividende_s9"},
                            {data: "dividende_k5_s10"}
                        ],
                        "columnDefs": [ {
                            "targets": 8,
                            "createdCell": function (td, cellData, rowData, row, col) {
                                if (cellData < 300 ) {
                                    $(td).css('background-color', 'red')
                                }else if(cellData < 700) {
                                    $(td).css('background-color', 'yellow')
                                }else{
                                    $(td).css('background-color', '#4CAF50')
                                }
                            }
                        } ]
                    });
                }
            });
        } else if('${kriterium}' == 4){
            alert("in 4")
            $.ajax({
                url: "getKriterium3",
                dataType: "json",
                type: "POST",
                success: function (json) {
                    $('#table').DataTable({
                        data: json,
                        columns: [
                            {data: "symbol"},
                            {data: "name_s1"},
                            {data: "konzurn_s2"},
                            {data: "price_s3"},
                            {data: "tiefstand_s4"},
                            {data: "kriterium3_s5"},
                            {data: "hochstand_s6"},
                            {data: "million_s7"},
                            {data: "durchschnittsdivende_s8"},
                            {data: "dividende_s9"},
                            {data: "dividende_k5_s10"}
                        ],
                        "columnDefs": [ {
                            "targets": 8,
                            "createdCell": function (td, cellData, rowData, row, col) {
                                if (cellData < 300 ) {
                                    $(td).css('background-color', 'red')
                                }else if(cellData < 700) {
                                    $(td).css('background-color', 'yellow')
                                }else{
                                    $(td).css('background-color', '#4CAF50')
                                }
                            }
                        } ]
                    });
                }
            });
        } else if('${kriterium}' == 3){
            $.ajax({
                url: "getKriterium3",
                dataType: "json",
                type: "POST",
                success: function (json) {
                    alert("in three")
                    $('#table').DataTable({
                        data: json,
                        columns: [
                            {data: "symbol"},
                            {data: "name_s1"},
                            {data: "konzurn_s2"},
                            {data: "price_s3"},
                            {data: "tiefstand_s4"},
                            {data: "kriterium3_s5"},
                            {data: "hochstand_s6"},
                            {data: "million_s7"},
                            {data: "durchschnittsdivende_s8"},
                            {data: "dividende_s9"},
                            {data: "dividende_k5_s10"}
                        ],
                        "columnDefs": [ {
                            "targets": 8,
                            "createdCell": function (td, cellData, rowData, row, col) {
                                if (cellData < 300 ) {
                                    $(td).css('background-color', 'red')
                                }else if(cellData < 700) {
                                    $(td).css('background-color', 'yellow')
                                }else{
                                    $(td).css('background-color', '#4CAF50')
                                }
                            }
                        } ]
                    });
                }
            });
        }else if('${kriterium}' == 2){
            $.ajax({
                url: "getKriterium2",
                dataType: "json",
                type: "POST",
                success: function (json) {
                   alert("in 2")
                    $('#table').DataTable({
                        data: json,
                        columns: [
                            {data: "symbol"},
                            {data: "name_s1"},
                            {data: "konzurn_s2"},
                            {data: "price_s3"},
                            {data: "tiefstand_s4"},
                            {data: "kriterium3_s5"},
                            {data: "hochstand_s6"},
                            {data: "million_s7"},
                            {data: "durchschnittsdivende_s8"},
                            {data: "dividende_s9"},
                            {data: "dividende_k5_s10"}
                        ],
                        "columnDefs": [ {
                            "targets": 8,
                            "createdCell": function (td, cellData, rowData, row, col) {
                                if (cellData < 300 ) {
                                    $(td).css('background-color', 'red')
                                }else if(cellData < 700) {
                                    $(td).css('background-color', 'yellow')
                                }else{
                                    $(td).css('background-color', '#4CAF50')
                                }
                            }
                        } ]
                    });
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    alert(xhr.response);
                    alert(thrownError);
                }
            });
        }else if('${kriterium}' == 1){
            $.ajax({
                url: "getKriterium1",
                dataType: "json",
                type: "POST",
                success: function (json) {
                    alert("in 1")
                    $('#table').DataTable({
                        data: json,
                        columns: [
                            {data: "symbol"},
                            {data: "name_s1"},
                            {data: "konzurn_s2"},
                            {data: "price_s3"},
                            {data: "tiefstand_s4"},
                            {data: "kriterium3_s5"},
                            {data: "hochstand_s6"},
                            {data: "million_s7"},
                            {data: "durchschnittsdivende_s8"},
                            {data: "dividende_s9"},
                            {data: "dividende_k5_s10"}
                        ],
                        "columnDefs": [ {
                            "targets": 8,
                            "createdCell": function (td, cellData, rowData, row, col) {
                                if (cellData < 300 ) {
                                    $(td).css('background-color', 'red')
                                }else if(cellData < 700) {
                                    $(td).css('background-color', 'yellow')
                                }else{
                                    $(td).css('background-color', '#4CAF50')
                                }
                            }
                        } ]
                    });
                }
            });
        }else{
            alert("in 0")
            $.ajax({
                url: "getData",
                dataType: "json",
                type: "POST",
                success: function (json) {
                    $('#table').DataTable({
                        data: json,
                        columns: [
                            {data: "symbol"},
                            {data: "name_s1"},
                            {data: "konzurn_s2"},
                            {data: "price_s3"},
                            {data: "tiefstand_s4"},
                            {data: "kriterium3_s5"},
                            {data: "hochstand_s6"},
                            {data: "million_s7"},
                            {data: "durchschnittsdivende_s8"},
                            {data: "dividende_s9"},
                            {data: "dividende_k5_s10"}
                        ],
                        "columnDefs": [ {
                            "targets": 8,
                            "createdCell": function (td, cellData, rowData, row, col) {
                                if (cellData < 300 ) {
                                    $(td).css('background-color', 'red')
                                }else if(cellData < 700) {
                                    $(td).css('background-color', 'yellow')
                                }else{
                                    $(td).css('background-color', '#4CAF50')
                                }
                            }
                        } ]
                    });
                }
            });
        }
    });
</script>
</body>
</html>
