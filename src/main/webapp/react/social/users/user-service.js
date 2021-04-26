const USERS_URL = `http://localhost:8080/orm/user`

export const findAllUsers = () =>
    fetch(`${USERS_URL}/find`)
        .then(response => response.json())

export const findUserById = (id) =>
    fetch(`${USERS_URL}/find/${id}`)
        .then(response => response.json())

export const deleteUser = (id) =>
    fetch(`${USERS_URL}/delete/${id}`, {
        method: "DELETE"
    })

export const createUser = (user) =>
    fetch(`${USERS_URL}/create/`, {
        method: 'POST',
        body: JSON.stringify(user),
        headers: {'content-type': 'application/json'}
    })
    .then(response => response.json())


export const updateUser = (id, user) =>
    fetch(`${USERS_URL}/update/${id}`, {
        method: 'PUT',
        body: JSON.stringify(user),
        headers: {'content-type': 'application/json'}
    })
    .then(response => response.json())


// TODO: export all functions as the API to this service
export default {
findAllUsers,
findUserById,
deleteUser,
createUser,
updateUser
}
