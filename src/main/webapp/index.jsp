<%@ page import="beans.EntryBean" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<jsp:useBean id="tableRows" class="beans.EntryBeansContainer" scope="session"/>

<html lang="en-En">

<head>
    <meta charset="UTF-8">
    <link rel="icon" href="img/favicon.ico">
    <link rel="stylesheet" href="css/stylesheet.css">
    <link href="https://fonts.googleapis.com/css2?family=PT+Serif&display=swap" rel="stylesheet" type="text/css">
    <title>Web$2</title>
</head>


<body>

<div id="main-container">

    <div id="head-area" class="coloured-block floating-areas">
        <span class="left-aligned">Inglikova Sofia, P3233</span>
        <span class="right-aligned">33345</span>
    </div>


    <div id="left-area" class="floating-areas">

        <div id="graph-block" class="content-plate">
            <div id="graph-heading" class="coloured-block">
                <span>Areas</span>
            </div>
            <div id="image-container">
                <canvas class="graph-canvas" width="300" height="240"></canvas>
                <svg id="graph-svg" width="300" height="240" class="svg-graph" xmlns="http://www.w3.org/2000/svg">

                    <line class="axis" x1="0" x2="300" y1="120" y2="120" stroke="black"></line>
                    <line class="axis" x1="150" x2="150" y1="0" y2="300" stroke="black"></line>
                    <polygon points="150,0 144,15 156,15" stroke="black"></polygon>
                    <polygon points="300,120 285,126 285,114" stroke="black"></polygon>

                    <line class="coor-line" x1="200" x2="200" y1="115" y2="125" stroke="black"></line>
                    <line class="coor-line" x1="250" x2="250" y1="115" y2="125" stroke="black"></line>

                    <line class="coor-line" x1="50" x2="50" y1="115" y2="125" stroke="black"></line>
                    <line class="coor-line" x1="100" x2="100" y1="115" y2="125" stroke="black"></line>

                    <line class="coor-line" x1="145" x2="155" y1="20" y2="20" stroke="black"></line>
                    <line class="coor-line" x1="145" x2="155" y1="70" y2="70" stroke="black"></line>

                    <line class="coor-line" x1="145" x2="155" y1="170" y2="170" stroke="black"></line>
                    <line class="coor-line" x1="145" x2="155" y1="220" y2="220" stroke="black"></line>

                    <text class="coor-text" x="195" y="140">R/2</text>
                    <text class="coor-text" x="248" y="140">R</text>

                    <text class="coor-text" x="40" y="140">-R</text>
                    <text class="coor-text" x="90" y="140">-R/2</text>

                    <text class="coor-text" x="160" y="75">R/2</text>
                    <text class="coor-text" x="160" y="25">R</text>

                    <text class="coor-text" x="160" y="175">-R/2</text>
                    <text class="coor-text" x="160" y="225">-R</text>

                    <polygon class="svg-figure rectangle" points="150,20 200,20 200,120, 150,120"
                             fill="#ebe5d5" fill-opacity="0.5" stroke="#d49c6b"></polygon>

                    <path class="svg-figure circle" d="M 50 120 A 100 100 0 0 1 150 20 V 120 H 50"
                          fill="#ebe5d5" fill-opacity="0.5" stroke="#d49c6b"></path>

                    <polygon class="svg-figure triangle" points="100,120 150,120 150,170"
                             fill="#ebe5d5" fill-opacity="0.5" stroke="#d49c6b"></polygon>

                    <circle r="0" cx="150" cy="120" id="dot" fill="#bc012a"></circle>

                    <%
                        String cx;
                        String cy;
                        for (EntryBean entryBean: tableRows.getEntryBeansContainer()) {
                            cx = String.valueOf(150 + Math.round(entryBean.getX()*100/entryBean.getR()));
                            System.out.println(cx);
                            cy = String.valueOf(120 - Math.round(entryBean.getY()*100/entryBean.getR()));
                            System.out.println(cy);
                    %>
                        <circle r="3" cx=<%=cx%> cy=<%=cy%> class="prev-dot" fill="#3a3e40"></circle>
                    <%}%>
                </svg>
            </div>
        </div>


        <div id="form-block" class="content-plate">

            <div id="form-heading" class="coloured-block">
                <span>Form</span>
            </div>

            <form id="values-form" action="/web2-0" method="GET">

                <div id="x-block">
                    <div id="xlabel" class="form-labels">
                        <label for="x-input">X</label>
                    </div>
                    <div id="xvalue" class="input-areas">
                        <input type="text" id="x-input" name="x" autocomplete="off" maxlength="10"
                               placeholder="Number from -3 to 5">
                    </div>
                </div>

                <div id="y-block">
                    <div id="ylabel" class="form-labels">
                        <label>Y</label>
                    </div>
                    <div id="yradio" class="input-areas">
                        <input type="radio" id="y-3" name="y" value="-3">
                        <label for="y-3">-3</label>

                        <input type="radio" id="y-2" name="y" value="-2">
                        <label for="y-2">-2</label>

                        <input type="radio" id="y-1" name="y" value="-1">
                        <label for="y-1">-1</label>

                        <input type="radio" id="y0" name="y" value="0">
                        <label for="y0">0</label>

                        <input type="radio" id="y1" name="y" value="1">
                        <label for="y1">1</label>

                        <input type="radio" id="y2" name="y" value="2">
                        <label for="y2">2</label>

                        <input type="radio" id="y3" name="y" value="3">
                        <label for="y3">3</label>

                        <input type="radio" id="y4" name="y" value="4">
                        <label for="y4">4</label>

                        <input type="radio" id="y5" name="y" value="5">
                        <label for="y5">5</label>

                    </div>
                </div>


                <div id="r-block">
                    <div id="rlabel" class="form-labels">
                        <label for="r-options">R</label>
                    </div>
                    <div id="rselection" class="input-areas">
                        <select id="r-options" name="r" size="1" required>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </div>
                </div>

                <div class="invisible">
                    <input class="clear_info" type="hidden" name="clear" value="false">
                </div>

                <div id="main-button-block">
                    <button class="main-button submit" type="submit" form="values-form">Submit</button>
                    <button class="main-button reset" type="submit" form="values-form">Reset</button>
                </div>

            </form>

        </div>

    </div>

    <div id="right-area" class="floating-areas content-plate">
        <div id="table-heading" class="coloured-block">
            <span>Table</span>
        </div>

        <div id="table-scroll-container">
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
                <% for (EntryBean entryBean: tableRows.getEntryBeansContainer()) { %>
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
        </div>

    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="js/main.js"></script>
</html>
