import {MKServer} from "@/pages/api/MKServer";
import bcrypt from 'bcrypt'

export default async function handler(req, res) {
    if(req.method == 'POST') {
        let hash = await bcrypt.hash(req.body.password, 10);
        console.log(hash);
        console.log(req.body);
        req.body.pssword = hash;

        MKServer.post('')
            .then()
            .catch()
            .finally();
    }
}