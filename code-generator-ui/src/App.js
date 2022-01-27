
import {useState } from 'react';
import './styles.css'



const App = () => {

  const [formValues, setFormValues] = useState([{ methodName: "", accessModifier : ""}])

  const [classVaues, setClassValues] = useState({ className: "", classAccessType : ""})
  const baseURL = "http://localhost:8082/generate";


  let handleClassChange = (e) => {
    let newFormValues = classVaues;
   // console.log("Log"+ classVaues + e.target.name);
    newFormValues[e.target.name] = e.target.value;
    setClassValues(classVaues);
  }

  let handleChange = (i, e) => {
      let newFormValues = [...formValues];
      newFormValues[i][e.target.name] = e.target.value;
      setFormValues(newFormValues);
    }
  
  let addFormFields = () => {
      setFormValues([...formValues, { methodName: "", accessModifier: "" }])
    }
  
  let removeFormFields = (i) => {
      let newFormValues = [...formValues];
      newFormValues.splice(i, 1);
      setFormValues(newFormValues)
  }
  
  let handleSubmit = (event) => {
      event.preventDefault();
      let newClassValues = classVaues;
      let newFormValues = [...formValues];

      //setClassValues(newFormValues);
     // console.log(JSON.stringify(newClassValues));
      //console.log(JSON.stringify(newFormValues));
      var result = 
        {
          "modelClass": [
            {
              "accessModifier": newClassValues.classAccessType,
              "className": newClassValues.className,
              "methods": newFormValues
            }
          ]
        }
      
    //  console.log(result);
      createPost(result);

  }

  function createPost(result) {
    const requestOptions = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify( result )
  };
  fetch(baseURL, requestOptions)
      .then(response => console.log((response.text)));
  }


  return (
      <form  onSubmit={handleSubmit}>
       
         <div className="form-inline" key={1}>
            <label>Class Name</label>
            <input type="text" name="className"  onChange={e => handleClassChange( e)} />
            <label>Class Access Specifier</label>
            <input type="text" name="classAccessType"  onChange={e => handleClassChange( e)} />
          </div>
        {formValues.map((element, index) => (
          <div className="form-inline" key={index}>
            <label>Method Name</label>
            <input type="text" name="methodName" value={element.methodName || ""} onChange={e => handleChange(index, e)} />
            <label>Method Access Secifier</label>
            <input type="text" name="accessModifier" value={element.accessModifier || ""} onChange={e => handleChange(index, e)} />
            {
              index ? 
                <button type="button"  className="button remove" onClick={() => removeFormFields(index)}>Remove</button> 
              : null
            }
          </div>
        ))}
        <div className="button-section">
            <button className="button add" type="button" onClick={() => addFormFields()}>Add</button>
            <button className="button submit" type="submit">Submit</button>
        </div>
    </form>
  )
}
export default App;
