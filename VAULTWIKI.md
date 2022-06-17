#HashiCorp
## Steps:
###
1. guide to follow: https://spring.io/guides/gs/vault-config/#scratch
2. To run hashicorp server:
   ```vault server --dev --dev-root-token-id="00000000-0000-0000-0000-000000000000"```
   
3. To create secrets:


```vault kv put secret/my-hashi-corp-vault kbvault.username=NealTest kbvault.password=Ptp#p00xrt56```

```vault kv put secret/my-hashi-corp-vault/cloud kbvault.username=DanielTest kbvault.password=yTp#p67xrt56```
   
4. Now you have written two entries in Vault _secret/my-hashi-corp-vault_ and _secret/my-hashi-corp-vault/cloud_.

5. Go to localhost:8200 to see ui of hashi corp vault. token is always:: ```00000000-0000-0000-0000-000000000000```
