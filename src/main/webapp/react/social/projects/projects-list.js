const {Link, useHistory} = window.ReactRouterDOM;

import projectService from "./projects-service"
const { useState, useEffect } = React;
const UserList = () => {
    const [projects, setProjects] = useState([])
    useEffect(() => {
        findAllProjects()
    }, [])
    const findAllProjects = () =>
        projectService.findAllProjects()
            .then(projects => setProjects(projects))

    const history = useHistory()

    return(
            <div>
                <h2>Projects</h2>
                 <button onClick={() => history.push("/projects/new")}>
                                Add Project
                  </button>

            <ul className="list-group">
                {
                    projects.map(project =>
                        <li key={project.id}>
                            <Link to={`/projects/${project.id}`}>
                                {project.id},
                                {project.description}
                            </Link>
                        </li>)
                }
            </ul>
            <button onClick={() => history.push("/users")}>
                Users
            </button>
            <button onClick={() => history.push("/mappings")}>
                            Mappings
            </button>
            </div>
        )

}


export default UserList;