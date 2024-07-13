const options = {
    method: 'GET',
    headers: {
      accept: 'application/json',
      Authorization: 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhYTJjYTAwZDYxZWIzOTEyYjZlNzc4MDA4YWQ3ZmNjOCIsInN1YiI6IjYyODJmNmYwMTQ5NTY1MDA2NmI1NjlhYyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.4MJSPDJhhpbHHJyNYBtH_uCZh4o0e3xGhZpcBIDy-Y8'
    }
  };
  

  function getPelis() {
//    const respuesta = fetch(`https://api.themoviedb.org/3/movie/top_rated`, options);
    const respuesta = fetch(`http://localhost:8080/listarPeliculas`);

    //2 invocar
    respuesta
        .then(response => response.json())
        .then(response => renderPelis(response))//fulfilled
        .catch(error => dibujarError(error))//rejected
  }

  function renderPelis(response) {
    const peliculas = response;
    let rows = '';
    for(let peli of peliculas) {
        rows += `
        <tr>
            <td>${peli.titulo}</td>
            <td>${peli.anio}</td>
            <td>${peli.puntuacion}</td>
            <td>
              <img src="${peli.portada}" alt="" class="img-fluid">
            </td>
            <td>
              <button>
                <i class="bi bi-trash-fill" onclick="delPeli(${peli.id})"></i>
              </button>  
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