const {useState, useEffect } = React;
const {Link} = window.ReactRouterDOM;

const InlineProjectEditor = ({project, deleteProject, updateProject}) => {
    const [projectCopy, setProjectCopy] = useState(project)
    const [editing, setEditing] = useState(false)
    return(
        <div>
            {
                editing &&
                <div className="row">
                    <div className="col">
                        <input
                            className="form-control"
                            value={projectCopy.id}
                            onChange={(e)=>setProjectCopy(projectCopy => ({...projectCopy, id: e.target.value}))}/>
                    </div>
                    <div className="col">
                        <input
                            className="form-control"
                            value={projectCopy.description}
                            onChange={(e)=>setProjectCopy(projectCopy => ({...projectCopy, description: e.target.value}))}/>
                    </div>

                    <div className="col-2">
                        <i className="fas fa-2x fa-check float-right margin-left-10px"
                           onClick={() => {
                               setEditing(false)
                               updateProject(projectCopy.id, projectCopy)
                           }}></i>
                        <i className="fas fa-2x fa-undo float-right margin-left-10px"
                           onClick={() => setEditing(false)}></i>
                        <i className="fas fa-2x fa-trash float-right margin-left-10px"
                           onClick={() => deleteProject(project.id)}></i>
                    </div>
                </div>
            }
            {
                !editing &&
                <div className="row">
                    <div className="col">
                        <Link to={`/projects/${projectCopy.id}`}>
                            {projectCopy.id}
                        </Link>
                    </div>
                    <div className="col">
                        <Link to={`/projects/${projectCopy.id}`}>
                            {projectCopy.description}
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

export default InlineProjectEditor;