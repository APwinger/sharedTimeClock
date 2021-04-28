const {useState, useEffect } = React;
const {Link} = window.ReactRouterDOM;

const InlineMappingEditor = ({mapping, deleteMapping, updateMapping}) => {
    const [mappingCopy, setMappingCopy] = useState(mapping)
    const [editing, setEditing] = useState(false)
    return(
        <div>
            {
                editing &&
                <div className="row">
                    <div className="col">
                        <input
                            className="form-control"
                            value={mappingCopy.firstName}
                            onChange={(e)=>setMappingCopy(mappingCopy => ({...mappingCopy, firstName: e.target.value}))}/>
                    </div>
                    <div className="col">
                        <input
                            className="form-control"
                            value={mappingCopy.lastName}
                            onChange={(e)=>setMappingCopy(mappingCopy => ({...mappingCopy, lastName: e.target.value}))}/>
                    </div>
                    <div className="col">
                        <input
                            className="form-control"
                            value={mappingCopy.mappingname}
                            onChange={(e)=>setMappingCopy(mappingCopy => ({...mappingCopy, mappingname: e.target.value}))}/>
                    </div>
                    <div className="col-1">
                        <Link to={`/mappings/${mappingCopy.id}/blogs`}>
                            Blogs
                        </Link>
                    </div>
                    <div className="col-2">
                        <i className="fas fa-2x fa-check float-right margin-left-10px"
                           onClick={() => {
                               setEditing(false)
                               updateMapping(mappingCopy.id, mappingCopy)
                           }}></i>
                        <i className="fas fa-2x fa-undo float-right margin-left-10px"
                           onClick={() => setEditing(false)}></i>
                        <i className="fas fa-2x fa-trash float-right margin-left-10px"
                           onClick={() => deleteMapping(mapping.id)}></i>
                    </div>
                </div>
            }
            {
                !editing &&
                <div className="row">
                    <div className="col">
                        <Link to={`/mappings/${mappingCopy.id}`}>
                            {mappingCopy.firstName}
                        </Link>
                    </div>
                    <div className="col">
                        <Link to={`/mappings/${mappingCopy.id}`}>
                            {mappingCopy.lastName}
                        </Link>
                    </div>
                    <div className="col">
                        <Link to={`/mappings/${mappingCopy.id}`}>
                            {mappingCopy.mappingname}
                        </Link>
                    </div>
                    <div className="col-1">
                        <Link to={`/mappings/${mappingCopy.id}/blogs`}>
                            Blogs
                        </Link>
                    </div>
                    <div className="col-2">
                        <i className="fas fa-cog fa-2x float-right"
                           onClick={() => setEditing(true)}></i>
                    </div>
                </div>
            }
        </div>
    )
}

export default InlineMappingEditor;