import ProjectsList from "./projects/projects-list";
import ProjectsFormEditor from "./projects/projects-form-editor";
const {HashRouter, Route} = window.ReactRouterDOM; 
const App = () => {
    return (
        <div className="container-fluid">
            <HashRouter>
                <Route path={["/projects", "/"]} exact={true}>
                    <ProjectsList/>
                </Route>
                <Route path="/projects/:id" exact={true}>
                     <ProjectsFormEditor/>
                </Route>
            </HashRouter>
        </div>
    );
}

export default App;
