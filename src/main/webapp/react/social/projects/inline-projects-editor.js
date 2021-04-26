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
                            value={projectCopy.firstName}
                            onChange={(e)=>setProjectCopy(projectCopy => ({...projectCopy, firstName: e.target.value}))}/>
                    </div>
                    <div className="col">
                        <input
                            className="form-control"
                            value={projectCopy.lastName}
                            onChange={(e)=>setProjectCopy(projectCopy => ({...projectCopy, lastName: e.target.value}))}/>
                    </div>
                    <div className="col">
                        <input
                            className="form-control"
                            value={projectCopy.projectname}
                            onChange={(e)=>setProjectCopy(projectCopy => ({...projectCopy, projectname: e.target.value}))}/>
                    </div>
                    <div className="col-1">
                        <Link to={`/projects/${projectCopy.id}/blogs`}>
                            Blogs
                        </Link>
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
                            {projectCopy.firstName}
                        </Link>
                    </div>
                    <div className="col">
                        <Link to={`/projects/${projectCopy.id}`}>
                            {projectCopy.lastName}
                        </Link>
                    </div>
                    <div className="col">
                        <Link to={`/projects/${projectCopy.id}`}>
                            {projectCopy.projectname}
                        </Link>
                    </div>
                    <div className="col-1">
                        <Link to={`/projects/${projectCopy.id}/blogs`}>
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

export default InlineProjectEditor;