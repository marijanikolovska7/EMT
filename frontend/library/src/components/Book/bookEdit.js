import React from "react";
import {useHistory,useParams} from "react-router-dom";

const BookEdit = (props) => {
    const history = useHistory();
    const params = useParams();
    const [formData, updateData] = React.useState({
        name: "",
        author: 0,
        availableCopies: 0,
        category: ""
    })
    const handleChange = (e) => {
        updateData({
            name: props.book.name,
            author: props.book.author,
            availableCopies: props.book.availableCopies,
            category: props.book.category,
            [e.target.name]: e.target.value,
        })
    }
    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name;
        const author = formData.author;
        const availableCopies = formData.availableCopies;
        const category = formData.category;
        props.editBook(params.id, name, author, availableCopies, category)
        history.push("/books", {replace: true})
    }
    return (

        <div className="col mt-5">
            <div className="container">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Book Name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               placeholder={props.book.name}
                               onChange={handleChange}/>
                    </div>
                    <div className="form-group">
                        <label>Author</label>
                        <select name="authorId" onChange={handleChange} className="form-control">
                            {props.authors.map((term) => {
                                if (props.book.author !== undefined && props.book.author.id === term.id) return <option
                                    value={term.id} selected={term.id}>{term.name} {term.surname}</option>
                                else return <option value={term.id}>{term.name} {term.surname}</option>
                            })}

                        </select>
                    </div>

                    <div className="form-group">
                        <label htmlFor="copies">Available Copies</label>
                        <input type="text"
                               className="form-control"
                               id="availableCopies"
                               name="availableCopies"
                               placeholder={props.book.availableCopies}
                               onChange={handleChange}/>
                    </div>
                    <div className="form-group">
                        <label>Category</label>
                        <select name="category" onChange={handleChange} className="form-control">
                            {props.categories.map((term) => {
                                if (props.book !== undefined && props.book.category == term)
                                    return <option value={term} selected={term}>{term}</option>
                                else return <option value={term}>{term}</option>
                            })}
                        </select>
                    </div>
                        <button className=" btn btn-primary" type="submit">Submit</button>
                </form>
            </div>
        </div>
    )
}
export default BookEdit;
