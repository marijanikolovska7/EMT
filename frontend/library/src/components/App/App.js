import './App.css';
import {Component} from "react";
import {BrowserRouter as Router,Redirect,Route} from "react-router-dom";
import Book from "../Book/books";
import Categories from "../Categories/categories";
import Library from "../../repository/booksRepository";
import Header from "../Header/header";
import BookEdit from "../Book/bookEdit";
import BookAdd from "../Book/bookAdd";
import author from "../Author/author";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      books: [],
      categories: [],
      authors: [],
      selectedBook: {}
    }
  }
  render(){
    return(
        <Router>
            <Header/>
            <main>
                <div className="container">
                    <Route path={"/authors"} exact render={() =>
                        <author authors={this.state.authors}/>}/>
                    <Route path={"/categories"} exact render={() =>
                        <Categories categories={this.state.categories}/>}/>
                    <Route path={"/books/add"} exact render={() =>
                        <BookAdd categories={this.state.categories}
                                    authors={this.state.authors}
                                    onAdd={this.addBook}/>}/>
                    <Route path={"/books/edit/:id"} exact render={() =>
                        <BookEdit categories={this.state.categories}
                                     authors={this.state.authors}
                                     editBook={this.editBook}
                                     book={this.state.selectedBook}/>}/>
                    <Route path={"/books"} exact render={() =>
                        <Book books={this.state.books}
                                  onDelete={this.deleteBook}
                                  onEdit={this.getBookById}/>}/>
                    <Redirect to={"/books"}/>
                </div>
            </main>
        </Router>

    );
  }
componentDidMount() {
    this.loadBooks();
    this.loadCategories();
    this.loadAuthors();
}
loadBooks = () =>{
    Library.fetchBooks()
        .then((data) => {
          this.setState({
            books:data.data
          })
        })
}
loadAuthors = () => {
    Library.fetchAuthors()
        .then((data) => {
          this.setState({
            authors:data.data
          })
        })
}
deleteBook = (id) => {
    Library.deleteBook(id)
        .then(() => {
          this.loadBooks();
        })
}
addBook = (name,author,availableCopies,category) => {
    Library.addBook(name,author,availableCopies,category)
        .then(() => {
          this.loadBooks();
        })
}
editBook = (id,name,author,availableCopies,category) => {
    Library.editBook(id,name,author,availableCopies,category)
        .then(() => {
          this.loadBooks()
        })
}
loadCategories = () => {
    Library.fetchCategories()
        .then((data) => {
          this.setState({
            categories:data.data
          })
        })
}
getBookById = (id) => {
    Library.getBookById(id)
        .then((data) => {
          this.setState({
            selectedBook: data.data,
          })
        })
}
}
export default App;
