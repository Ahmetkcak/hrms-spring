package kodlamaio.hrms.core.utilities.adapters.mernis;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisAuthenticationAdapter {
	public boolean authenticate(String identityNumber, String firstName, String lastName, int birthYear) {
		KPSPublicSoap client = new KPSPublicSoapProxy();
		
		boolean result = false;
		try {
			result = client.TCKimlikNoDogrula(Long.parseLong(identityNumber), firstName.toUpperCase(), lastName.toUpperCase(), birthYear);
			return result;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
