package agawrylak.credit.services;

import agawrylak.credit.dtos.CreditDTO;
import agawrylak.credit.models.Credit;
import agawrylak.credit.repositories.CreditRepository;
import agawrylak.credit.wrappers.CreditMap;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CreditService {

    final CreditRepository creditRepository;

    private ModelMapper modelMapper;

    public CreditService(CreditRepository creditRepository, ModelMapper modelMapper) {
        this.creditRepository = creditRepository;
        this.modelMapper = modelMapper;
    }

    public int addAndGetId(CreditDTO creditDTO) {
        Credit credit = convertToEntity(creditDTO);
        return this.creditRepository.save(credit).getId();
    }

    public CreditMap getAll() {
        List<Credit> creditList = creditRepository.findAll();
        HashMap<Integer, CreditDTO> resultMap = new HashMap<>();
        for (Credit credit : creditList) {
            resultMap.put(credit.getId(), convertToDTO(credit));
        }
        CreditMap creditMap = new CreditMap();
        creditMap.setMap(resultMap);
        return creditMap;
    }

    public List<Integer> getAllIds() {
        List<Credit> creditList = creditRepository.findAll();
        List<Integer> idList = new ArrayList<>();
        for (Credit credit : creditList) {
            idList.add(credit.getId());
        }
        return idList;
    }

    private Credit convertToEntity(CreditDTO creditDTO) {
        return modelMapper.map(creditDTO, Credit.class);
    }

    private CreditDTO convertToDTO(Credit credit) {
        return modelMapper.map(credit, CreditDTO.class);
    }


}
