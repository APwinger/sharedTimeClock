import UserList from "./users/user-list";
import UserFormEditor from "./users/user-form-editor";
import ProjectsList from "./projects/projects-list";
import ProjectsFormEditor from "./projects/projects-form-editor";
import MappingList from "./users_to_projects/mapping-list";
import MappingFormEditor from "./users_to_projects/mapping-form-editor";
import ProjNav from "./projects.js"
const {HashRouter, Route} = window.ReactRouterDOM; 
const App = () => {
    return (
        <div className="container-fluid">
            <HashRouter>
                <Route path={["/users", "/"]} exact={true}>
                    <UserList/>
                </Route>
                <Route path="/users/:id" exact={true}>
                    <UserFormEditor/>
                </Route>
                <Route path="/projects" exact={true} component={ProjNav}>
                    <ProjectsList/>
                </Route>
                <Route path="/projects/:id" exact={true}>
                     <ProjectsFormEditor/>
                </Route>
                <Route path="/mappings" exact={true}>
                    <MappingList/>
                </Route>
                <Route path="/mappings/:id" exact={true}>
                     <MappingFormEditor/>
                </Route>
            </HashRouter>
        </div>
    );
}

export default App;
