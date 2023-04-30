import axios from "../custom-axios/axios";

const Library = {
    fetchBooks: () => {
        return axios.get("/books");
    },
    fetchCategories: () => {
        return axios.get("/categories");
    },
    fetchAuthors: () => {
        return axios.get("/authors")
    },
    deleteBook: (id) => {
        return axios.delete("/books/delete/{id}")
    },

    addBook: (name,author,avaliableCopies,category) => {
        return axios.post("/books/add", {
            "name":name,
            "author":author,
            "availableCopies":avaliableCopies,
            "category":category
        });
    },
    editBook: (id,name,author,availableCopies,category) => {
        return axios.put("/books/edit/${id}", {
            "name":name,
            "author":author,
            "availableCopies":availableCopies,
            "category":category
        })
    },
    getBookById:(id) => {
        return axios.get("/books/${id}");
}
}
export default Library;