const PROJECTS_URL = `http://localhost:8080/orm/project`

export const findAllProjects = () =>
    fetch(`${PROJECTS_URL}/find`)
        .then(response => response.json())

export const findProjectById = (id) =>
    fetch(`${PROJECTS_URL}/find/${id}`)
        .then(response => response.json())

export const deleteProject = (id) =>
    fetch(`${PROJECTS_URL}/delete/${id}`, {
        method: "DELETE"
    })

export const createProject = (project) =>
    fetch(`${PROJECTS_URL}/create/`, {
        method: 'POST',
        body: JSON.stringify(project),
        headers: {'content-type': 'application/json'}
    })
    .then(response => response.json())


export const updateProject = (id, project) =>
    fetch(`${PROJECTS_URL}/update/${id}`, {
        method: 'PUT',
        body: JSON.stringify(project),
        headers: {'content-type': 'application/json'}
    })
    .then(response => response.json())


// TODO: export all functions as the API to this service
export default {
findAllProjects,
findProjectById,
deleteProject,
createProject,
updateProject
}
