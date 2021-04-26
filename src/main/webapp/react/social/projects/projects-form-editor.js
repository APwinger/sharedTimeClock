import projectService from "./projects-service"
const {useState, useEffect} = React;
const {useParams, useHistory} = window.ReactRouterDOM;
const ProjectFormEditor = () => {
    const {id} = useParams()
    const history = useHistory()
    const [project, setProject] = useState({})
    useEffect(() => {
        findProjectById(id)
    }, []);
    const findProjectById = (id) =>
        projectService.findProjectById(id)
            .then(project => setProject(project))

    const createProject = (project) =>
        projectService.createProject(project)
            .then(() => history.goBack())

     const updateProject = (id, newProject) =>
            projectService.updateProject(id, newProject)
                .then(() => history.goBack())

    const deleteProject = (id) =>
            projectService.deleteProject(id)
                .then(() => history.goBack())
    return (
        <div>
            <h2>Project Editor</h2>
            <label>id</label>
            <input
                value={project.id}/>
<br/>
            <label>Description</label>
            <input
                onChange={(e) =>
                    setProject(project =>
                        ({...project, description: e.target.value}))}
                value={project.description}/>

<br/>
                <button onClick={() => {
                        history.goBack()}}>
                    Cancel
                </button>

                 <button
                     onClick={() => deleteProject(project.id)}>
                     Delete
                 </button>

                <button
                    onClick={() => createProject(project)}>
                    Create
                </button>

                <button
                    onClick={() => updateProject(project.id, project)}>
                    Save
                </button>

            </div>
)
}

export default ProjectFormEditor