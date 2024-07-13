const options = {
    method: 'GET',
    headers: {
      accept: 'application/json',
      Authorization: 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhYTJjYTAwZDYxZWIzOTEyYjZlNzc4MDA4YWQ3ZmNjOCIsInN1YiI6IjYyODJmNmYwMTQ5NTY1MDA2NmI1NjlhYyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.4MJSPDJhhpbHHJyNYBtH_uCZh4o0e3xGhZpcBIDy-Y8'
    }
  };
  

  function getProductos() {
//    const respuesta = fetch(`https://api.themoviedb.org/3/movie/top_rated`, options);
    const respuesta = fetch(`http://localhost:8080/listarProductos`);

    //2 invocar
    respuesta
        .then(response => response.json())
        .then(response => renderProd(response))//fulfilled
        .catch(error => dibujarError(error))//rejected
  }

  function renderProd(response) {
    const peliculas = response;
    let rows = '';
    for(let peli of peliculas) {
        rows += `
        <tr>
            <td>${peli.id}</td>
            <td>${peli.nombre}</td>
            <td>${peli.precio}</td>
             
            </td>
        </tr>
        `
    }
    // document.getElementById("peliculas").innerHTML = rows;
    document.querySelector('#peliculas').innerHTML = rows;
}

function delPeli(id) {
  //    const respuesta = fetch(`https://api.themoviedb.org/3/movie/top_rated`, options);
      const respuesta = fetch(`http://localhost:8080/delPelicula/${id}`, {
        method: 'DELETE',
      });
  
      //2 invocar
      respuesta
          .then(response => okDel(response))//fulfilled
          .catch(error => dibujarError(error))//rejected
    }

function okDel(response) {
  document.querySelector('#peliculas').innerHTML = "Se eliminó exitosamente";
}

function dibujarError(error) {
  document.querySelector('#peliculas').innerHTML = error;
}