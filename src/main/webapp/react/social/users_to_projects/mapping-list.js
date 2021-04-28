const {Link, useHistory} = window.ReactRouterDOM;

import mappingService from "./mapping-service"
const { useState, useEffect } = React;
const MappingList = () => {
    const [mappings, setMappings] = useState([])
    useEffect(() => {
        findAllMappings()
    }, [])
    const findAllMappings = () =>
        mappingService.findAllMappings()
            .then(mappings => setMappings(mappings))

    const history = useHistory()

    return(
            <div>
                <h2>Mappings</h2>
                 <button onClick={() => history.push("/mappings/new")}>
                                Add Mapping
                  </button>

            <ul className="list-group">
                {
                    mappings.map(mapping =>
                        <li key={mapping.id}>
                            <Link to={`/mapping/${mapping.id}`}>
                                {mapping.id},
                                {mapping.user},
                                {mapping.project},
                                {mapping.role}
                            </Link>
                        </li>)
                }
            </ul>

            <button onClick={() => history.push("/projects")}>
                Projects
            </button>
            <button onClick={() => history.push("/users")}>
                            Users
            </button>
            </div>
        )

}


export default MappingList;