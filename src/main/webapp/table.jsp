<%@ page import="beans.EntryBean" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="tableRows" class="beans.EntryBeansContainer" scope="session"/>
<table id="result-table">
    <thead>
        <tr id="table-header">
            <th class="coords-col">X</th>
            <th class="coords-col">Y</th>
            <th class="coords-col">R</th>
            <th class="time-col">Current time</th>
            <th class="time-col">Execution time</th>
            <th class="hitres-col">Hit result</th>
        </tr>
    </thead>
    <% for (EntryBean entryBean : tableRows.getEntryBeansContainer()) { %>
    <tr>
        <td><%= entryBean.getX()%></td>
        <td><%= entryBean.getY()%></td>
        <td><%= entryBean.getR()%></td>
        <td><%= entryBean.getCurrentTime()%></td>
        <td><%= entryBean.getExecTime()%></td>
        <td><%= entryBean.isHit()%></td>
    </tr>
    <%}%>

</table>
