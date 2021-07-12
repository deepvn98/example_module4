window.onload = function () {
    showAllCity()
}


function showAllCity() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/city",
        success: function (data) {
            console.log(data)
            let c = `<div id="list_city">`;
            for (let i = 0; i < data.length; i++) {
                c += ` 
        <tr>
            <td>${data[i].name}</td>
            <td>${data[i].country.name}</td>
            <td>${data[i].area}</td>
            <td>${data[i].population}</td>
            <td>${data[i].gDP}</td>
            <td>${data[i].description}</td>
            <th>delete</th>
            <th>update</th>
        </tr>`;
            }
            c += `</div>`;
            document.getElementById("list_city").innerHTML = c;
        }
    });
}
