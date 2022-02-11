window.onload = () =>{
    
    //SAVING INITIAL DATA FOR CANCEL
    let id = parseInt(document.getElementById("antecedent_id").value);
    let initial_diagnostic = document.getElementById("diagnostic").value;
    let initial_treatment = document.getElementById("treatment").value;
    let initial_doctor = document.getElementById("doctor").value;
    let initial_sicknessStart = document.getElementById("sicknessStart").value;
    let initial_sicknessEnd = document.getElementById("sicknessEnd").value;
    

    //AUTO SAVE
    setInterval(()=>{
        var diagnostic = document.getElementById("diagnostic").value;
        var treatment = document.getElementById("treatment").value;
        var doctor = document.getElementById("doctor").value;
        var sicknessStart = document.getElementById("sicknessStart").value;
        var sicknessEnd = document.getElementById("sicknessEnd").value;

        var antecedant = new FormData();

        antecedant.append("diagnostic",diagnostic );
        antecedant.append("treatment", treatment);
        antecedant.append("doctor", doctor);
        antecedant.append("sicknessStart", sicknessStart);
        antecedant.append("sicknessEnd",sicknessEnd);

        console.log(JSON.stringify(Object.fromEntries(antecedant)));

        (async () => {
            const rawResponse = await fetch("/api/antecedants/"+id+"/save", {
              method: 'POST',
              headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
              },
              body: JSON.stringify(Object.fromEntries(antecedant))
            });
            const content = await rawResponse.text();
            console.log(content);
          })();


      
    }, 10000);
        
    //CANCEL
    document.getElementById("cancel").addEventListener('click', function(){
       
      var antecedant = new FormData();

      antecedant.append("diagnostic",initial_diagnostic );
      antecedant.append("treatment", initial_treatment);
      antecedant.append("doctor", initial_doctor);
      antecedant.append("sicknessStart", initial_sicknessStart);
      antecedant.append("sicknessEnd",initial_sicknessEnd);

      console.log(JSON.stringify(Object.fromEntries(antecedant)));

      (async () => {
          const rawResponse = await fetch("/api/antecedants/"+id+"/cancel", {
            method: 'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(Object.fromEntries(antecedant))
          });
          const content = await rawResponse.text();
          if(rawResponse.status == 200){
            console.log("content");
            window.location.href= " http://localhost:8888/documents";
          }
        })();
        
    });

    //SUBMIT
    document.getElementById("submit").addEventListener('click', function(){
        var id = document.getElementById("antecedent_id").value;
        var diagnostic = document.getElementById("diagnostic").value;
        var treatment = document.getElementById("treatment").value;
        var doctor = document.getElementById("doctor").value;
        var sicknessStart = document.getElementById("sicknessStart").value;
        var sicknessEnd = document.getElementById("sicknessEnd").value;

        var antecedant = new FormData();
        
        antecedant.append("diagnostic",diagnostic );
        antecedant.append("treatment", treatment);
        antecedant.append("doctor", doctor);
        antecedant.append("sicknessStart", sicknessStart);
        antecedant.append("sicknessEnd",sicknessEnd);

        console.log(JSON.stringify(Object.fromEntries(antecedant)));

        (async () => {
            const rawResponse = await fetch("/api/antecedants/"+id+"/save", {
              method: 'POST',
              headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
              },
              body: JSON.stringify(Object.fromEntries(antecedant))
            });
            const content = await rawResponse.text();
            if(rawResponse.status == 200){
              console.log("submit");
              window.location.href= " http://localhost:8888/documents";
            }
          })();
      });

}
