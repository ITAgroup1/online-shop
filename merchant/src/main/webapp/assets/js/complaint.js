$(document).ready(function ()  {

    //config
    axios.defaults.withCredentials = true;

    listComplaint();

    async function listComplaint() {
        let res = await axios.get("http://localhost:9090/complaint/");
        let param = res.data;
        console.log(res);
        if(param.status === "1"){
            console.log(param.data);
        }
    }
});