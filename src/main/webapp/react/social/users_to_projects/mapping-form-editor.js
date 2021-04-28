import projectService from "../projects/projects-service";
import userService from "../users/user-service";
import mappingService from "./mapping-service";
const {useState, useEffect} = React;
const {useParams, useHistory} = window.ReactRouterDOM;
const MappingFormEditor = () => {
    const {mapId} = useParams()
    const history = useHistory()
    const [mapping, setMapping] = useState({})
    const [user, setUser] = useState({})
    const [project, setProject] = useState({})
    const userId = findMappingById(mapId).user
    const projectId = findMappingById(mapId).project

    useEffect(() => {
    if(id !== "new") {
            findMappingById(mapId),
            findUserById(userId),
            findProjectById(projectId)
            }

    }, []);

    const findUserById = (userId) =>
        userService.findUserById(userId)
            .then(user => setUser(user))

    const findProjectById = (projectId) =>
        projectService.findProjectById(projectId)
            .then(project => setProject(project))

    const findMappingById = (mapId) =>
        mappingService.findMappingById(mapId)
            .then(mapping => setMapping(mapping))

    const createMapping = (mapping) =>
        mappingService.createMapping(mapping)
            .then(() => history.goBack())

     const updateMapping = (mapId, newMapping) =>
            mappingService.updateMapping(mapId, newMapping)
                .then(() => history.goBack())

    const deleteMapping = (mapId) =>
            mappingService.deleteMapping(mapId)
                .then(() => history.goBack())
    return (
        <div>
            <h2>Mapping Editor</h2>
            <label>User</label>
            <input
                onChange={(e) =>
                    setUser(user =>
                        ({...user, id: e.target.value}))}
                value={mapping.id}/>
<br/>
            <label>Project</label>
            <input
                onChange={(e) =>
                    setProject(project =>
                        ({...project, id: e.target.value}))}
                value={project.id}/>
<br/>
            <label>Role</label>
            <input
                onChange={(e) =>
                    setMapping(mapping =>
                        ({...mapping, role: e.target.value}))}
                value={mapping.role}/>

<br/>
                <button

                    onClick={() => {
                        history.goBack()}}>
                    Cancel
                </button>

                 <button
                     onClick={() => deleteMapping(mapping.id)}>
                     Delete
                 </button>

                <button
                    onClick={() => createMapping(mapping)}>
                    Create
                </button>

                <button
                    onClick={() => updateMapping(mapping.id, mapping)}>
                    Save
                </button>

            </div>
)
}

export default MappingFormEditor