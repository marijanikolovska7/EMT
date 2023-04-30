import React from "react";
import {useHistory} from "react-router-dom";

const BookAdd = (props) => {

    const history = useHistory();
    const[formData, updateData] = React.useState({
        name:"",
        author:1,
        availableCopies:0,
        category:"NOVEL",
    })

    const handleChange= (e) => {
        updateData({
            ...formData,
            [e.target.name]: e.target.value,
        })
    }
    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name;
        const author = formData.author;
        const availableCopies = formData.availableCopies;
        const category = formData.category;
        props.onAdd(name,author,availableCopies,category)
        history.push("/books",{replace: true})
    }
    return (
        <div className="col mt-5">
            <div className="container">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group" >
                        <label htmlFor="name">Book Name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               placeholder="Enter Book name"
                               onChange={handleChange} />
                    </div>
                    <div className="form-group">
                        <label>Author</label>
                        <select name="authorId" onChange={handleChange} className="form-control">
                            {props.authors.map((term)=><option value={term.id}>{term.name} {term.surname}</option>)}
                        </select>
                    </div>

                    <div className="form-group">
                        <label htmlFor="copies">Available Copies</label>
                        <input type="text"
                               className="form-control"
                               id="availableCopies"
                               name="availableCopies"
                               required
                               placeholder="Enter Available Copies"
                               onChange={handleChange}/>
                    </div>
                    <div className="form-group">
                        <label>Category</label>
                        <select name="category"  onChange={handleChange} className="form-control">
                            {props.categories.map((term)=><option value={term}>{term}</option>)}
                        </select>

                    </div>
                        <button id="submit" className=" btn btn-primary" type="submit" >Submit</button>
                </form>
            </div>
        </div>
    )
}
export default BookAdd;