const MAPPINGS_URL = `http://localhost:8080/orm/mapping`

export const findAllMappings = () =>
    fetch(`${MAPPINGS_URL}/find`)
        .then(response => response.json())

export const findMappingById = (id) =>
    fetch(`${MAPPINGS_URL}/find/${id}`)
        .then(response => response.json())

export const deleteMapping = (id) =>
    fetch(`${MAPPINGS_URL}/delete/${id}`, {
        method: "DELETE"
    })

export const createMapping = (mapping) =>
    fetch(`${MAPPINGS_URL}/create/`, {
        method: 'POST',
        body: JSON.stringify(mapping),
        headers: {'content-type': 'application/json'}
    })
    .then(response => response.json())

export const updateMapping = (id, mapping) =>
    fetch(`${MAPPINGS_URL}/update/${id}`, {
        method: 'PUT',
        body: JSON.stringify(mapping),
        headers: {'content-type': 'application/json'}
    })
    .then(response => response.json())


// TODO: export all functions as the API to this service
export default {
findAllMappings,
findMappingById,
deleteMapping,
createMapping,
updateMapping
}
